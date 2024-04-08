// import logo from './logo.svg';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import LoginPage from './Components/LoginPage';
import EmployeeDashboard from "./Components/EmpDashboard";
import AddSalary from "./Components/AddSalary";
import UpdateSalary from "./Components/UpdateSalary";

function App() {
  return (
    <div className="App">
      <Router>

        <Routes>
          <Route exact path="/" element={<LoginPage/>} />
          <Route exact path="/employee/:id" element={<EmployeeDashboard />} />
          <Route exact path="/employee/update/:id" element={<UpdateSalary/>}/>
          <Route exact path="/employee/:id/add" element={<AddSalary/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
