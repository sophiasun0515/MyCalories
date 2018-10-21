from django.db import models

# Create your models here.
class Info(models.Model): #get features form default jango model class
    unit = models.CharField(max_length = 200) #connected to db
    item = models.CharField(max_length = 200)
    calorie = models.IntegerField()

class Record(models.Model):
    uid = models.IntegerField()
    time = models.DateTimeField(auto_now=True)
    cal = models.IntegerField()
    item = models.CharField(max_length = 200)
