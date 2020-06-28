
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
          .then(response => {
                return response.json()
            })
            .then(data => {
                return data
            })
        },

    register : (data) => {
        console.log(registrationEndPoint);
    }
}


export default AuthenticationService;