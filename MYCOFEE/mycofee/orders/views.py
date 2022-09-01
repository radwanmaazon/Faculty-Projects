from django.shortcuts import render,redirect
from django.contrib import messages
#from mycofee.products.views import product
from products.models import Product
from orders.models import Order
from orders.models import OrderDetails
from .models import Payment
from django.utils import timezone, translation


def add_to_cart(request):
    if request.user.is_authenticated and 'pro_id' in request.GET and 'qty' in request.GET and 'price' in request.GET and not request.user.is_anonymous :
        pro_id  = request.GET['pro_id']
        qty     = request.GET['qty']

        
        order = Order.objects.all().filter(user=request.user ,is_finished=False)
        if not Product.objects.all().filter(id =pro_id).exists():
            return redirect('products')
        pro = Product.objects.get(id=pro_id)
        if int(qty) > 0 :
            if order :
                #messages.success(request ,'There are old Item')
                old_order =Order.objects.get(user=request.user ,is_finished=False)
                if OrderDetails.objects.all().filter(order=old_order,product=pro).exists():
                    orderdetails=OrderDetails.objects.get(order=old_order,product=pro)
                    orderdetails.quantity += int(qty)
                    orderdetails.save()
                else :
                    orderdetails            =OrderDetails.objects.create(product=pro ,order=old_order ,price=pro.price ,quantity=qty)
                messages.success(request ,'Item has been added to the cart')
            else :
                #messages.success(request ,'Item has been added')
                new_order               = Order()
                new_order.user          =request.user 
                new_order.order_date    =timezone.now()
                new_order.is_finished   =False 
                new_order.save()
                orderdetails            =OrderDetails.objects.create(product=pro ,order=new_order ,price=pro.price ,quantity=qty)
                messages.success(request ,'First item has been added to the cart')

            return redirect('/products/' + pro_id)
        else :
            messages.error(request ,"Please Enter Valied Quantity ")
            return redirect('/products/' + pro_id)
    elif not request.user.is_authenticated :
        pro_id  = request.GET['pro_id']
        messages.error(request,"You must Sign in ")
        #return render(request ,'accounts/signin.html')
        return redirect('/products/' + pro_id)
    else :
        return redirect('products')

def cart(request):
    context =None 
    if request.user.is_authenticated and not request.user.is_anonymous :
        if Order.objects.all().filter(user=request.user,is_finished=False):
            order           =Order.objects.get(user=request.user,is_finished=False)
            orderdetails    =OrderDetails.objects.all().filter(order=order)
            total           =0
            for sub in orderdetails :
                total += sub.price * sub.quantity 
            context ={
                'order'         :order ,
                'orderdetails'  :orderdetails ,
                'total'         :total,
            }
    return render(request ,'orders/cart.html' ,context)

def remove_from_cart(request ,orderdetails_id):
    if request.user.is_authenticated and not request.user.is_anonymous and orderdetails_id:
        orderdetails= OrderDetails.objects.get(id=orderdetails_id)
        if orderdetails.order.user.id == request.user.id :
            orderdetails.delete()
    return redirect('cart')

def add_qty(request ,orderdetails_id):
    if request.user.is_authenticated and not request.user.is_anonymous and orderdetails_id:
        orderdetails= OrderDetails.objects.get(id=orderdetails_id)
        if orderdetails.order.user.id == request.user.id :
            orderdetails.quantity +=1
            orderdetails.save()
    return redirect('cart')

def sub_qty(request ,orderdetails_id):
    if request.user.is_authenticated and not request.user.is_anonymous and orderdetails_id:
        orderdetails= OrderDetails.objects.get(id=orderdetails_id)
        if orderdetails.order.user.id == request.user.id :
            if orderdetails.quantity >1 :
                orderdetails.quantity -=1
                orderdetails.save()
    return redirect('cart')

def payment(request):
    context=None 
    ship_address    =None 
    ship_phone      =None
    card_number     =None
    expire          =None
    security_code   =None
    is_added        =None

    if request.method == 'POST' and 'btnpayment' in request.POST and 'ship_address' in request.POST and 'ship_phone' in request.POST and 'card_number' in request.POST and 'expire' in request.POST and 'security_code' in request.POST:
        #Here the process of payment after push button
        ship_address    =request.POST['ship_address'] 
        ship_phone      =request.POST['ship_phone']
        card_number     =request.POST['card_number']
        expire          =request.POST['expire']
        security_code   =request.POST['security_code']

        if request.user.is_authenticated and not request.user.is_anonymous :
            if Order.objects.all().filter(user=request.user,is_finished=False):
                order           =Order.objects.get(user=request.user,is_finished=False)
                payment =Payment(order=order ,shipment_address=ship_address ,shipment_phone=ship_phone ,card_number=card_number ,expire=expire ,security_code=security_code)
                payment.save()
                order.is_finished=True
                order.save()
                is_added =True
                messages.success(request ,'Your Message is success')

        context={
        'ship_address'  :ship_address,
        'ship_phone'    :ship_phone,
        'card_number'   :card_number,
        'expire'        :expire,
        'security_code' :security_code,
        'is_added'      :is_added,
        }
    else :
        #Here the process before payment
        if request.user.is_authenticated and not request.user.is_anonymous :
            if Order.objects.all().filter(user=request.user,is_finished=False):
                order           =Order.objects.get(user=request.user,is_finished=False)
                orderdetails    =OrderDetails.objects.all().filter(order=order)
                total           =0
                for sub in orderdetails :
                    total += sub.price * sub.quantity 
                context ={
                    'order'         :order ,
                    'orderdetails'  :orderdetails ,
                    'total'         :total,
                }
    return render(request ,'orders/payment.html' ,context)

def show_orders(request):
    context =None
    all_orders=None
    if request.user.is_authenticated and not request.user.is_anonymous :
        all_orders =Order.objects.all().filter(user=request.user)
        if all_orders:
            for x in all_orders :
                order           =Order.objects.get(id=x.id)
                orderdetails    =OrderDetails.objects.all().filter(order=order)
                total           =0
                for sub in orderdetails :
                    total += sub.price * sub.quantity
                x.total =total
                x.items_count =orderdetails.count
    context={'all_orders' :all_orders}
    return render(request ,'orders/show_orders.html' ,context)