import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';
import axios from 'axios';
import { toast } from 'react-toastify';

type Props = {
    saleId: number;
}

function handleClick(id: number){
    axios(`${BASE_URL}/sales/${id}/notification`)
        .then(response => {
            console.log("SMS sent successfully!");
            toast.info("SMS sent successfully!");
        });
}

function NotificationButton( {saleId} : Props) {
    return (
        <div className="sales-red-btn" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton