var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Shape = /** @class */ (function () {
    function Shape() {
    }
    Shape.prototype.disp = function () {
        console.log("Area of Square is=" + this.area);
    };
    Shape.prototype.disp1 = function () {
        console.log("Area of Rectangle is=" + this.area);
    };
    return Shape;
}());
var Square = /** @class */ (function (_super) {
    __extends(Square, _super);
    function Square(side) {
        var _this = _super.call(this) || this;
        _this.side = side;
        return _this;
    }
    Square.prototype.Area = function () {
        this.area = this.side * this.side;
        this.disp();
    };
    return Square;
}(Shape));
var Rectangle = /** @class */ (function (_super) {
    __extends(Rectangle, _super);
    function Rectangle(l, w) {
        var _this = _super.call(this) || this;
        _this.w = w;
        _this.l = l;
        return _this;
    }
    Rectangle.prototype.Area = function () {
        this.area = this.l * this.w;
        this.disp1();
    };
    return Rectangle;
}(Shape));
var objSquare = new Square(2);
objSquare.Area();
var objRectangle = new Rectangle(3, 5);
objRectangle.Area();
