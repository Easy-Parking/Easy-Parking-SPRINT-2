import React, { Component } from 'react';
import ParticlesBg from 'particles-bg';

import DraggableLayouts from "../../components/parkingDraggable/DraggableLayouts";

import Cookies from 'js-cookie';
import { Redirect } from 'react-router-dom';



class HomePage extends Component {

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
                <ParticlesBg color="#7C00C8" type="circle" bg={true} />
                <h1>Home Page</h1>

                <DraggableLayouts />
            </div>
        )
    }
}

export default HomePage;