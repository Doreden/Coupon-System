import Footer from "../Footer/Footer";
import Header from "../Header/Header";
import Routing from "../Routing/Routing";
import Menu from "../Menu/Menu";
import "./Layout.css";

function Layout(): JSX.Element {
    return (
        <div className="Layout">
           
            <header>
                <Header/>
            </header>

            <aside>
                <Menu />
            </aside>
            
            <main>
                <Routing />
            </main>
           
            <footer>
                <Footer/>
            </footer>

        </div>
    );
}

export default Layout;
