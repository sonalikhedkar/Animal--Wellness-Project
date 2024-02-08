
import './App.css';
import Header from './Components/Header';
import Footer from './Components/Footer';
import MainNavBar from './Components/MainNavBar';
import HomeComponent from './pages/HomeComponent';
import { Route,Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Header></Header>
      <MainNavBar></MainNavBar>
      <Routes>
        <Route path="/home" element={<HomeComponent></HomeComponent>}></Route>
        
      </Routes>
      <Footer></Footer>
    </div>
  );
}

export default App;
