import React, { Component } from 'react'
import { Text, View, Button } from 'react-native'
// import Voice from 'react-native-voice'

class CalorieFetch extends Component {
    constructor() {
        super();
        this.state = {
            calorie: []
        }

        this.fetchCalorie = this.fetchCalorie.bind(this)
    }

    componentDidMount() {

    }

    fetchCalorie = (calorieString) => {
        fetch('https://radiant-brook-49591.herokuapp.com/getCalories/', {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(calorieString)})
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            console.log(data.calorie);
            this.setState({calorie: data.calorie});
            console.log(this.state.calorie);
            return data;
        })
    }

    render() {
        return (
            <React.Fragment>
                <View>
                    <Text>hello</Text>
                    <Text>{this.state.calorie}</Text>
                </View>
                <Button
                    onPress={ () => { this.fetchCalorie("one bowl of rice") } }
                    title="Get Calories"
                />
            </React.Fragment>
        )
    }
}

export default CalorieFetch;