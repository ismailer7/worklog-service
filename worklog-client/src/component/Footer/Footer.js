import React, { Component } from 'react';
import './static/style.css';

class Footer extends Component {
    render() {
        return (
            <div>
                <footer id="sticky-footer" class="py-2">
                    <div className="container text-center">
                    <small>Copyright &copy; Work Log Service.</small>
                    </div>
                </footer>
            </div>
        )
    }
}

export default Footer;