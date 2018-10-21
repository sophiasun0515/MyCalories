from dbAccess import Calorie

def retrieveUnitItemFromText(text):
    text = processText(text)
    words = text.split()

    num = None
    if (len(words) >= 1):
        num = getIntFromString(words[0])
    else:
        return -1

    unit = None
    if (len(words) >= 2):
        unit = getUnit(words[1])
    else:
        return -1

    item = None
    if (len(words) >= 4):
        item = words[3]
    else:
        return -1

    totalCalorie = num * Calorie.getCalorieByUnitItem(unit, item)[0][0]

    if totalCalorie > 0:
        Calorie.insertCalorieRecord(totalCalorie, item)
        return totalCalorie
    else:
        return -1


def processText(text):
    return text

def getUnit(unitString):
    if unitString == "cup" or unitString == "cups":
        return "cup"
    elif unitString == "bowl" or unitString == "bowls":
        return "bowl"
    elif unitString == "unit" or unitString == "units":
        return "unit"
    elif unitString == "slice" or unitString == "slices":
        return "slice"
    elif unitString == "bottle" or unitString == "bottles":
        return "bottle"
    elif unitString == "tablespoon" or unitString == "tablespoons":
        return "tablespoon"
    elif unitString == "loaf" or unitString == "loafs":
        return "loaf"
    elif unitString == "can" or unitString == "cans":
        return "can"
    elif unitString == "peice" or unitString == "peices":
        return "peice"
    elif unitString == "bag" or unitString == "bags":
        return "bag"
    elif unitString == "glass" or unitString == "glasses":
        return "glass"
    elif unitString == "spoon" or unitString == "spoons":
        return "spoon"
    else:
        return "unit"


def getIntFromString(numberString):
    if numberString == 'one' or numberString == "1":
        return 1
    elif numberString == 'two' or numberString == "2":
        return 2
    elif numberString == 'three' or numberString == "3":
        return 3
    elif numberString == 'four' or numberString == "4":
        return 4
    elif numberString == 'five' or numberString == "5":
        return 5
    elif numberString == 'six' or numberString == "6":
        return 6
    elif numberString == 'seven' or numberString == "7":
        return 7
    elif numberString == 'eight' or numberString == "8":
        return 8
    elif numberString == 'nine' or numberString == "9":
        return 9
    elif numberString == 'ten' or numberString == "10":
        return 10
    else:
        return 0
    