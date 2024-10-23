import logo from '../../assets/img/logo.svg';
import './styles.css';

function Header() {
    return (
        <header>
            <div className="sales-logo-container">
                <img src={logo} alt="sales" />
                <h1>Sales APP</h1>
                <p>
                    Developed by
                    <a href="https://github.com/allexolic" target='_blank'> allexolic</a>
                </p>
            </div>
        </header>
    )
}

export default Header