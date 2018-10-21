# voice-calories-app

### Django Environment Setup

#### Dependencies needed

Django<br/>
`pip install django`<br/>

Django Restful API Fraimwork<br/>
`pip install djangorestframework`<br/>
`pip install markdown       # Markdown support for the browsable API`<br/>

#### Run the backend server

Use the environment:<br/>
`source bin/activate`<br/>

Serve:
`python manage.py runserver`<br/>

Sync the database: <br/>
`python manage.py migrate`

Make new component:<br/>
`Python manage.py startapp product`<br/>
`Python manage.py makemigrations`<br/>
`Python manage.py migrate`<br/>

#### Run the frontend server

Use the environment:<br/>
`cd frontend/`<br/>
`npm install -g expo-cli`<br/>

Serve:
`npm start`<br/>
Go to webpage, and choose either `Run on Android`

### Note:

"frontend" file is a backup of the old react native fronend that is not currently used



