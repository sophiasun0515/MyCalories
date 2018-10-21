from django.shortcuts import render

from django.contrib.auth.models import User, Group
from product.models import Info
from rest_framework import viewsets
from product.serializers import UserSerializer, GroupSerializer, ProductSerializer
from rest_framework.response import Response
from dbAccess import Calorie
from rest_framework.decorators import api_view
from service import text
from service import record

import json


# Create your views here.
class ProductViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.
    """
    queryset = Info.objects.all()
    serializer_class = ProductSerializer

from rest_framework.decorators import api_view

@api_view(['POST'])
def getCalories(request):
    print(request.data['text'])
    data = text.retrieveUnitItemFromText(request.data['text'].lower())
    return Response({"calorie": data})

@api_view(['POST'])
def getRecordList(request):
    print(request.data)
    if (len(request.data) != 2):
        return Response({"data":-1, "error":"incorrect JSON length"})
    if ('time' not in request.data.keys() or 'uid' not in request.data.keys()):
        return Response({"data":-1, "error":"incorrect JSON elements"})

    list = record.retrieveRecordListByTimeID(request.data['time'], request.data['uid'])

    outList = []
    for i in list:
        cur = {}
        cur['item'] = i[0]
        cur['calorie'] = i[1]
        outList.append(cur)

    return Response({'data':outList})

# @api_view(['POST'])
# def storeData(request):
#     list = record.retrieveRecordListByTimeID(request.data['time'], request.data['uid'])

#     return Response({'data':outList})
