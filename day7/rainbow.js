let c = document.getElementById("canvas");
let ctx = c.getContext("2d");

let colors = ["red", "orange", "yellow", "green", "blue", "indigo", "violet", "white"]

for (let i = 0; i < colors.length; i++) {
    ctx.beginPath();
    ctx.arc(350, 350, 200 - 20 * i, Math.PI, 0, false);
    ctx.fillStyle = colors[i];
    ctx.fill();
}