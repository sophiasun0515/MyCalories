# Generated by Django 2.1.2 on 2018-10-20 01:44

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('product', '0004_info_calorie'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='info',
            name='number',
        ),
    ]
