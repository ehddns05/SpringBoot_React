import React from 'react';
import logo from './logo.svg';
import './App.css';
import { observable, reaction, computed, autorun } from 'mobx';

// **** Observable State 만들기
const calculator = observable({
  a: 1,
  b: 2
});

const sum = computed(() => {
  console.log('계산중이예요!');
  return calculator.a + calculator.b;
});

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
             
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        {calculator.a}
      </header>
    </div>
  );
}

export default App;
