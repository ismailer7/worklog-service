import React, { Component } from 'react';
import { BrowserRouter as Link} from 'react-router-dom';
import './static/index.css';
import AuthenticationService from '../../service/AuthenticationSerivce';
import Footer from '../Footer/Footer';
class Registration extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            repeatedPAssword: '',
            email: ''
        };
    
        this.handleChangeUsername = this.handleChangeUsername.bind(this);
        this.handleChangePassword = this.handleChangePassword.bind(this);
        this.handleChangeRepeatPassword = this.handleChangeRepeatPassword.bind(this);
        this.handleChangeEmail = this.handleChangeEmail.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
      }

      handleChangeUsername(event) {
        this.setState({username: event.target.value});
      }

      handleChangeEmail(event) {
        this.setState({email: event.target.value});
      }

      handleChangePassword(event) {
        this.setState({password: event.target.value});
      }

      handleChangeRepeatPassword(event) {
        this.setState({repeatedPAssword: event.target.value});
      }

      componentDidUpdate(prevProps, prevState) {
      }

      handleSubmit(event) {
        event.preventDefault();
        AuthenticationService.register(this.state) 
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
    	                    <h4 class="modal-title">Register an Account</h4>
                        <div class="form-group">
                            <input type="text" class="form-control" defaultValue={this.state.username} onChange={this.handleChangeUsername} placeholder="Username" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" defaultValue={this.state.email} onChange={this.handleChangeEmail} placeholder="Email" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" defaultValue={this.state.password} onChange={this.handleChangePassword} placeholder="Password" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" defaultValue={this.state.repeatedPAssword} onChange={this.handleChangeRepeatPassword} placeholder="Confirm Password" required="required" />
                        </div>
                        <input type="submit" class="btn btn-primary btn-block btn-lg" value="Sing Up" />              
                    </form>			
                    <div class="text-center small">Already have an account? <Link to={'/login'}><a href="#">Login</a></Link></div>
                </div>
                <Footer />
                </div>
            )
        }
}

export default Registration;