from product.models import Info
from django.db import connection

def getCalorieByUnitItem(unit, item):
    c = connection.cursor()
    calorie = c.execute('SELECT calorie FROM product_info WHERE unit = %s AND item = %s', [unit, item])
    return calorie.fetchall()

def insertCalorieRecord(totalCalorie, item):
    c = connection.cursor()
    c.execute("insert into product_record (uid, time, cal, item) values (%s, date('now'), %s, %s)", [1, totalCalorie, item])