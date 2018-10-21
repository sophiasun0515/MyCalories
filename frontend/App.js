import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import CalorieFetch from './components/calorieFetch';

export default class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text>App.js to start working on your app!</Text>
        ReactDOM.render(<CalorieFetch />)
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
