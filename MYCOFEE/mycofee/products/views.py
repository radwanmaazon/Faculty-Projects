from typing import cast
from django.shortcuts import get_object_or_404, render
from datetime import datetime
from .models import Product
# Create your views here.

def products(request):
    pro =Product.objects.all()

    name    =''
    desc    =''
    pfrom   =''
    pto     =''
    cs      =''

    if 'cs' in request.GET:
        cs =request.GET['cs']
        if not cs:
            cs ='off'

    if 'searchname' in request.GET:
        name =request.GET['searchname']
        if name:
            if cs=='on':
                pro =pro.filter(name__contains=name)                                               #i =insensitive  
            else :
                pro =pro.filter(name__icontains=name)

    if 'searchdesc' in request.GET:
        desc =request.GET['searchdesc']
        if desc:
            if cs=='on':
                pro =pro.filter(description__contains=desc)
            else :
                pro =pro.filter(description__icontains=desc)

    if 'searchpricefrom' in request.GET and 'searchpriceto' in request.GET:
        pfrom=request.GET['searchpricefrom']
        pto  =request.GET['searchpriceto'] 
        if pfrom and pto :
            if pfrom.isdigit() and pto.isdigit():
                pro =pro.filter(price__gte=pfrom ,price__lte=pto )  #greter than or equal =gte

    context ={
        'products': pro,
    }
    return render(request ,'products/products.html' ,context)

def product(request ,pro_id):
    context ={
        'pro' :get_object_or_404(Product ,pk=pro_id)
    }
    return render(request ,'products/product.html' ,context)

def search(request):
    return render(request ,'products/search.html')


