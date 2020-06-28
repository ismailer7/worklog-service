import React, { Component } from 'react';
import { BrowserRouter as Link} from 'react-router-dom';
import './static/index.css';
import AuthenticationService from '../../service/AuthenticationSerivce';
import Footer from '../Footer/Footer';
class Authentication extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            message: '',
            token: ''
        };
    
        this.handleChangeUsername = this.handleChangeUsername.bind(this);
        this.handleChangePassword = this.handleChangePassword.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
      }

      handleChangeUsername(event) {
        this.setState({username: event.target.value});
      }

      handleChangePassword(event) {
        this.setState({password: event.target.value});
      }

      componentDidUpdate(prevProps, prevState) {
      }

      handleSubmit(event) {
        event.preventDefault();
        AuthenticationService.authenticate(this.state.username, this.state.password) 
                        .then( response => {
                            console.log(response)
                        })
    }

      render() {
        // const errorMsg = this.state.errorMessage
            return (
                <div>
                <div class="login-form">    
                    <form id="loginForm" onSubmit={this.handleSubmit}>
		                <div class="avatar"><i class="material-icons">&#xE7FF;</i></div>
    	                    <h4 class="modal-title">Login to Your Account</h4>
                            <div class="alert alert-danger alert-dismissible fade show">
                                <strong>Attention!</strong> Invalid Credentials.
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                            </div>

                        <div class="form-group">
                            <input type="text" class="form-control" defaultValue={this.state.username} onChange={this.handleChangeUsername} placeholder="Username" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" defaultValue={this.state.password} onChange={this.handleChangePassword} placeholder="Password" required="required" />
                        </div> 
                        <div class="form-group small clearfix">
                            <label class="form-check-label"><input type="checkbox" /> Remember me </label>
                            <a href="#" class="forgot-link">Forgot Password?</a>
                        </div> 
                        <input type="submit" class="btn btn-primary btn-block btn-lg" value="Login" />              
                    </form>			
                    <div class="text-center small">Don't have an account? <Link to={'/register'}><a href="#">Sign up</a></Link></div>
                </div>
                <Footer />
                </div>
            )
        }
}

export default Authentication;