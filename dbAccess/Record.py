from product.models import Record
from django.db import connection

def getRecordByTimeId(time, uid):
    c = connection.cursor()
    recordListById = c.execute("SELECT item, cal FROM product_record WHERE uid = %s AND time == date('now')", [uid])
    # print (recordListById.fetchall())
    recordList = recordListById.fetchall()

    map = {}
    outputList = []
    for item in recordList:
        if item[0] in map.keys():
            map[item[0]] = map[item[0]] + item[1]
        else:
            map[item[0]] = item[1]
    for key in map.keys():
        outputList.append((key, map[key]))
    return outputList