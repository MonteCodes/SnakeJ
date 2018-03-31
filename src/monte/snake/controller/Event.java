package monte.snake.controller;

import monte.snake.model.Direction;

public class Event {


    static class Builder {
        private boolean win;
        private boolean loss;
        private Direction direction;
        private boolean ateFood;

        Builder() {
        }

        Builder win(boolean win) {
            this.win = win;

            return this;
        }

        Builder loss(boolean loss) {
            this.loss = loss;

            return this;
        }

        Builder direction(Direction direction) {
            this.direction = direction;

            return this;
        }

        Builder ateFood(boolean ateFood) {
            this.ateFood = ateFood;

            return this;
        }

        public Event build() {
            Event event = new Event();
            event.win = this.win;
            event.loss = this.loss;
            event.direction = this.direction;
            event.moved = !this.win && !this.loss;
            event.ateFood = this.ateFood;

            return event;
        }


    }

    public boolean win;
    public boolean loss;
    public Direction direction;
    public boolean moved;
    public boolean ateFood;

    private Event() {

    }



}
