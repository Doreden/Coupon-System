import "./PageNotFound.css";
import pageNotFoundImage from "../../../Assets/404 error2.png";

function PageNotFound(): JSX.Element {
    return (
        <div className="PageNotFound">
            <img src={pageNotFoundImage} />
        </div>
    );
}

export default PageNotFound;
