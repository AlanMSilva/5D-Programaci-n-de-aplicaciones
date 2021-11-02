import React, { useState } from 'react'
import { StyleSheet, Text, TextInput, TouchableOpacity, View, Image, Alert} from 'react-native';



function App() {

  const [name, setName] = useState('');
  const [age, setAge] = useState('');

  return (
    <View style = {styles.Container}>
        <Image
        style = {styles.Image}
        source={{uri: 'https://cdn-icons-png.flaticon.com/512/2357/2357423.png'}}/>

        <Text 
          style = {styles.Text}>Tu Nombre</Text>
        <TextInput 
          style  = {styles.TextInput}
          placeholder ="Nombre"
          onChangeText={val => setName(val)}/>

        <Text style = {styles.Text}>Tu Edad</Text>
        <TextInput 
        style  = {styles.TextInput}
        placeholder="Edad"
        onChangeText={val => setAge(val)}/>
        
        <TouchableOpacity 
        style = {styles.Button}
        onPress={() => {
          var ageS = parseInt(age);
          var suma = 0;
          var res = 0;
          var x = 0;
          if(age == '' || name == '')
              Alert.alert("rellena los campos");
          else if(ageS <10 ) {
              suma = ageS * 7
              while(suma > 10){
                res = suma % 10;
                x = Math.floor(suma/10)
                suma = res + x;
              }
              Alert.alert("Hey "+ name + " Your lucky number is: " + suma);
          }else{
            suma = ageS;
            while(suma > 10){
              res = suma % 10;
              x = Math.floor(suma/10)
              suma = res + x;
              }
              Alert.alert("Hey "+ name + " Your lucky number is: " + suma);
          }
        }}>
              <Text style = {styles.ButtonText}>Obtener Numero</Text>
          </TouchableOpacity>
    </View>
  )
};



const styles = StyleSheet.create({
  Image:{
    height: 200,
    width: 200,
    marginBottom: 50,
  },
  Container:{
    alignItems: 'center',
    backgroundColor: '#202020',
    display: 'flex',
    height: '100%',
    justifyContent: 'center',
  },
  Text:{
    fontSize: 20,
    fontWeight: '700',
    letterSpacing: 2,
    color: "white",
  },
  Button:{
    borderRadius: 8,
    paddingHorizontal: 14,
    paddingVertical: 10,
    backgroundColor: '#350480',
    marginTop: 20,
  },
  ButtonText:{
      color:'white',
      fontSize: 20,
      fontWeight: 'bold',
      textAlign: 'center',
  },
  TextInput:{
    borderWidth: 1,
    borderColor: 'white',
    padding: 8,
    margin: 10,
    width: 200,
  }
});

export default App; 
