from django.contrib.messages.api import success
from django.shortcuts import redirect, render
from django.contrib import messages
from django.contrib.auth.models import User 
from django.contrib import auth

from products.models import Product
from .models import UserProfile
from django.http import HttpResponse
import re 


# Create your views here.

def signin(request):
    if request.method =='POST' and 'btnlogin' in request.POST :

        username =request.POST['user']
        password =request.POST['pass']

        user =auth.authenticate(username=username ,password=password)
        if user is not None:
            if 'rememberme' not in request.POST:
                request.session.set_expiry(0)
            auth.login(request ,user)
            #messages.success(request ,'success log in ')
        else :
            messages.error(request ,'User name or password is invalid')

        return redirect('signin')
    else :
        return render(request ,'accounts/signin.html')

def logout(request):
    if request.user.is_authenticated :
        auth.logout(request)
    return redirect('index')

def signup(request):
    if request.method =='POST' and 'btnsignup' in request.POST:
    #Variable for fields
        fname =None
        lname =None
        address =None
        address2 =None
        city =None
        zip_number =None
        state =None
        email =None
        username =None
        password=None
        terms =None 
        is_added =None

    # Get value from form 
        if 'fname' in request.POST :    fname =request.POST['fname']
        else : messages.error(request ,'ERROR in first name field')

        if 'lname' in request.POST :    lname =request.POST['lname']
        else : messages.error(request ,'ERROR in last name field')

        if 'address' in request.POST :  address =request.POST['address']
        else : messages.error(request ,'ERROR in Address field')

        if 'address2' in request.POST : address2 =request.POST['address2']
        else : messages.error(request ,'ERROR in Address2 field')

        if 'city' in request.POST :     city =request.POST['city']
        else : messages.error(request ,'ERROR in City field')

        if 'zip' in request.POST :      zip_number=request.POST['zip']
        else : messages.error(request ,'ERROR in Zip_number field')

        if 'state' in request.POST :    state =request.POST['state']
        else : messages.error(request ,'ERROR in state field')

        if 'email' in request.POST :    email =request.POST['email']
        else : messages.error(request ,'ERROR in E-mail field')

        if 'user' in request.POST :     username =request.POST['user']
        else : messages.error(request ,'ERROR in User name field')

        if 'pass' in request.POST :     password =request.POST['pass']
        else : messages.error(request ,'ERROR in password field')

        if 'terms' in request.POST :    terms =request.POST['terms']
#        else : messages.error(request ,'You Should agree to the terms of use and privacy policy')

        #Check The values
        if fname and lname and address and address2 and city and zip_number and state and email and username and password:
            if terms =='on' :
                #Check User Name        
                if User.objects.filter(username=username).exists():
                    messages.error(request ,'User name is Exists')
                else :
                    #Check E-mail
                    if User.objects.filter(email=email).exists():
                        messages.error(request ,'E_Mail is Exists')
                    else :
                        patt ="^\w+([-+.']/w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"
                        if re.match(patt ,email):
                            #Add User
                            user =User.objects.create_user(first_name=fname ,last_name=lname ,email=email ,username=username ,password=password)
                            user.save()
                            #Add UserProfile
                            userprofile =UserProfile(user=user ,address=address ,address2=address2 ,city=city ,state=state ,zipnumber=zip_number)
                            userprofile.save()
                            #Clear Fields
                            fname =''
                            lname =''
                            address =''
                            address2 =''
                            city =''
                            zip_number =''
                            state =''
                            email =''
                            username =''
                            password=''
                            terms ='' 
                            is_added =''
                            #Success  
                            messages.success(request ,'Your Account is Created')
                            is_added =True                           
                            
                        else :
                            messages.error(request ,'Invalid E-Mail')
            else :
                messages.error(request ,'You must agree to the terms of use and privacy policy') 
        else :
            messages.error (request ,'Check Empty fields')

        return render(request ,'accounts/signup.html',{
            'fname':fname,
            'lname':lname,
            'address':address,
            'address2':address,
            'city':city,
            'state':state,
            'zip':zip_number,
            'email':email,
            'user':username,
            'pass':password,
            'is_added':is_added,
        })
    else :
        return render(request ,'accounts/signup.html')

def profile(request):
    if request.method == 'POST' and 'btnsave' in request.POST:

        if request.user is not None and request.user.id != None :
            userprofile =UserProfile.objects.get(user=request.user)

            if request.POST['fname'] and request.POST['lname'] and request.POST['address'] and request.POST['address2'] and request.POST['city'] and request.POST['state'] and request.POST['zip'] and request.POST['email'] and request.POST['user'] and request.POST['pass']:
                request.user.first_name =request.POST['fname']
                request.user.last_name =request.POST['lname']
                userprofile.address =request.POST['address']
                userprofile.address2 =request.POST['address2']
                userprofile.city =request.POST['city']
                userprofile.state =request.POST['state']
                userprofile.zipnumber =request.POST['zip']    
                #request.user.email =request.POST['email']
                #request.user.user  =request.POST['user']
                if not request.POST['pass'].startswith('pbkdf2_sha256$'):
                    request.user.set_password(request.POST['pass'])            
                request.user.save()
                userprofile.save() 
                auth.login(request ,request.user)               
                messages.success(request ,'Your data has been saved')
                

            else :
                messages.error(request ,'Check your values')

        return redirect('profile')
    else :
        if request.user is not None :
            userprofile =UserProfile.objects.get(user=request.user)
            context={
                'fname':request.user.first_name ,
                'lname':request.user.last_name ,
                'address':userprofile.address,
                'address2':userprofile.address2,
                'state' :userprofile.state,
                'zip' :userprofile.zipnumber,
                'city':userprofile.city,
                'email':request.user.email ,
                'user' :request.user.username,
                'pass':request.user.password,
            }
            return render(request ,'accounts/profile.html' ,context)
        else :
            return redirect('profile')

def product_favorite(request ,pro_id):
    if request.user.is_authenticated and not request.user.is_anonymous:
        pro_fav = Product.objects.get(pk =pro_id)
        if UserProfile.objects.filter(user=request.user ,product_favorites=pro_fav).exists():
            messages.success(request ,"This product is already exists in the favorite list ")
        else :
            userprofile =UserProfile.objects.get(user=request.user)
            userprofile.product_favorites.add(pro_fav)
            messages.success(request ,"The product has been added")

    else :
        if not request.user.is_authenticated :
            messages.error(request ,'You must be logged in')

    return redirect("/products/" + str(pro_id))

def show_product_favorite(request):
    context= None 
    if request.user.is_authenticated and not request.user.is_anonymous:
        userInfo=UserProfile.objects.get(user=request.user)
        pro =userInfo.product_favorites.all()
        context ={'products' :pro }
    return render(request ,'products/products.html' ,context)
    
    