import React from 'react'
import './style.css';

//          component : footer layout           //
export default function Footer() {

  //          render : footer  rendering           // 
    return (
    <div id='footer'>
        <div className='footer-container'>
            <div className='footer-top'>
                <div className='footer-logo-box'>
                    <div className='icon-box'>
                        <div className='logo-light-icon'></div>
                    </div>
                    <div className='footer-logo-text'></div>
                </div>
                <div className='footer-link-box'>
                    <div className='footer-email-link'></div>
                    <div className='icon-button'>
                        <div className='icon insta-icon'></div>
                    </div>
                    <div className='icon-button'>
                        <div className='icon naver-blog-icon'></div>
                    </div>
                </div>
            </div>
            <div className='footer-bottom'>
                <div className='footer-copyright'></div>
            </div>
        </div>
    </div>
    )
}
