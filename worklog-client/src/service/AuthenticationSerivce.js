
const authenticationEndPoint = 'http://localhost:8090/authenticate';
const registrationEndPoint = 'http://localhost:8090/register';

const AuthenticationService = {
    authenticate : (username, password) => {
        console.log('authenticate invoked.. with data : ' + username + ', ' + password)
        let result = {
            'status': '',
            'message': '',
            'username': '',
            'token': ''
        }
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
                result['username'] = username
                if(response.status !== 200) {
                    result['status'] = response.status // 401
                    return response.text()
                } else {
                    result['status'] = 200
                    result['message'] = 'Authenticated Successfully!'
                    return response.json()
                }
            })
            .then(data => {
                if(typeof(data) !== 'string') {
                  result['token'] = data['token']
                } else {
                    result['message'] = 'Authentication Failed, Please check your credentials!'
                }
                return result
            })
            .catch(err => console.error(err))
        },


    register : (data) => {
        console.log(registrationEndPoint);
    }
}


export default AuthenticationService;