from dbAccess import Record

def retrieveRecordListByTimeID(time, id):
    return Record.getRecordByTimeId(time, id)