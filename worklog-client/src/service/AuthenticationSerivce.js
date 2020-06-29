
const authenticationEndPoint = 'http://localhost:8090/authenticate';
const registrationEndPoint = 'http://localhost:8090/register';

const AuthenticationService = {
    authenticate : (username, password) => {
        return fetch(authenticationEndPoint, {
            method: 'POST',
            headers: new Headers({
                'Content-Type': 'application/json'
              }),
            body: JSON.stringify({
                "username": username,
                "password": password
            })
          })
          .then(response => response.json())
          .then(data => data)
        },

    register : (data) => {
        return fetch(registrationEndPoint, {
            method: 'POST',
            headers: new Headers({
                'Content-Type': 'application/json',
              }),
            body: JSON.stringify({
                "username": data['username'],
                "password": data['password'],
                "email": data['email'],
                "active": true,
                "role": "USER_ROLE" // default
            })
        })
        .then( response => response.text())
        .then(data => {
            return data
        })
        .catch(error => {
            console.log(error)
        })
    }
}


export default AuthenticationService;