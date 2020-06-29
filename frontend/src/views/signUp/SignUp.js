import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import Cookies from 'js-cookie';


class SignUp extends Component {

    constructor(props) {
        super(props);
        this.state = {
            authenticated: false,
            toSignup: false,
            email: "",
            password: ""
        }

    }

    render() {
        return (
            <div>
                SignUp Page
            </div>
        )
    }
}

export default SignUp;