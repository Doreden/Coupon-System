import "./Home.css";
import homeImage from "../../../Assets/Subject.png";
function Home(): JSX.Element {
    return (
        <div className="Home">
            <iframe className="gif1" src="https://giphy.com/embed/j3OtOBC5SVoUXgPkjF" frameBorder="0" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/noise-coupons-gonoise-coupon-code-j3OtOBC5SVoUXgPkjF"></a></p>
            <iframe className="gif2" src="https://giphy.com/embed/jslNz20tuRuJfu4pSh" frameBorder="0" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/haystravel-black-friday-deals-jslNz20tuRuJfu4pSh"></a></p>
            <iframe className="gif3" src="https://giphy.com/embed/SRmMYLzAL7Ph5gZuFv" frameBorder="0" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/buyonline-sensitivecbd-carrodelacompra-SRmMYLzAL7Ph5gZuFv"></a></p>
            <iframe className="gif4" src="https://giphy.com/embed/3I3WvKBml8D2i6joGG" frameBorder="0"  allowFullScreen></iframe><p><a href="https://giphy.com/gifs/IkejaWireless-ikeja-ikejawifi-ikejawireless-3I3WvKBml8D2i6joGG"></a></p>
            <img src={homeImage} />
        </div>
    );
}

export default Home;
