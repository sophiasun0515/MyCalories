# My Calories - Smart Daily Calories Voice Recorder
### TRACK CALORIE-INTAKE HANDS-FREE! 

Tell the app what you ate and it will do the rest for you within a second!

Here's the whole story:

### Inspiration
Have you ever downloaded a calorie tracking app on your smartphone and deleted it after few attempts because it was too much of a pain to use? Do you really have the time to type all the food you ate into a massive database and confuse yourself with all the similar items? Have you ever chosen to give up after inputting 3 food items because it has already taken about 10 minutes of your lunchtime? If you have ever felt any of these frustrations, this app is here for you! Our application is solely built based on a user-friendly principle to help us stay away from these troubles.


### What it does
- Take in voice of user about what they ate
- Search the food item in the database
- Show the total calorie intake of the day
- Inform the user of whether the calorie intake is too high, moderate, or too low
- The color scheme of green to red to visualize calorie intake amount 
- Show detail information of the calories of each food item the user ate
- History of how much calories the user ate for each food item

### How we built it
The frontend is developed and hosted on an Android device.
The frontend utilizes Google Voice Recognition Service to input user audio queries
The backend is developed in Python with django and its rest framework.
The backend RESTful API endpoints are deployed and hosted on Heroku
The data is sent and retrieved using RESTful web services
The SQLite database stores all the relevant data involving food calorie pairs and user record
We used GitHub as our central version control system.

### Challenges we ran into
Deployment configuration
UI from React Native to Android Studio
Backend RESTful endpoints development
Add Animation
End to end integration

### Accomplishments that we're proud of
Usability: Instead of typing in all the entries, just hold the button and tell the app what you ate. 
Simplicity: All the users have to do is speak, the rest of the work is taken care of.
Efficiency: Adding in an entire meal would take a user less than a minute.

### What we learned
Teamwork

### What's next for Voice Calorie Tracking
- Allow users to customize calories for food in the database
- User login page
- Allow calorie information sharing with friends
- More accurate fuzzy-search
- Bigger database (increase as user customize food calorie information)

### Scenario Example

### lite breakfast
- one cup of coffee
- one slice a bread

### time for lunch - no time!Need to be quick!
- three slices of pizza
- one can of soda

### I am sooo hungry!
- four pieces of cookie
(oh no!!!)

### Dinner
- one bowl of spaghetti
- two pieces of samon
- one cup of yoghert

### Before bed:
NOOOOOO too many calories
cut down my cookies!


--------------------------------------------------------------------------------------------------

### How to set up needed Dependencies

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



