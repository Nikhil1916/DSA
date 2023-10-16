var counter = 0;
function addCounter() {
  console.log(counter++);
  document.getElementById('showOutput').innerHTML = counter
}