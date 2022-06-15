let c = document.getElementById("canvas");
let ctx = c.getContext("2d");

for (let i = 0; i < 8; i++) {
    for (let j = 0; j < 8; j++) {
        if ((i + j) % 2 === 0) {
            ctx.fillStyle = "white";
        } else {
            ctx.fillStyle = "black";
        }
        ctx.fillRect(20 + 50 * i, 20 + 50 * j, 50, 50);
    }
}