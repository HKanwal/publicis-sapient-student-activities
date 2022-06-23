import './App.css';

function App() {
  let users = [
    { name: "Mark", age: 35, gender: "Male" },
    { name: "Suma", age: 40, gender: "Female" },
    { name: "Hark", age: 22, gender: "Male" },
    { name: "Jeremie Joseph Bornais the Third", age: 21, gender: "Male" },
    { name: "Paul", age: 22, gender: "Male" }
  ];

  return (
    <table>
      <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
      </tr>
      {
        users.map(user =>
          <tr>
            <td>{user.name}</td>
            <td>{user.age}</td>
            <td>{user.gender}</td>
          </tr>
        )
      }
    </table>
  );
}

export default App;
