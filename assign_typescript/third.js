var Circle = /** @class */ (function () {
    function Circle(radius, id, distanc) {
        this.radius = radius;
        this.id = id;
        this.distanc = distanc;
    }
    Circle.prototype.disp = function () {
        this.Circumference = 2 * this.id * this.radius;
        this.times = this.distanc / this.Circumference;
        console.log("Ring rotations=" + this.times);
    };
    return Circle;
}());
var C = new Circle(10, 15 / 4, 1400);
C.disp();
