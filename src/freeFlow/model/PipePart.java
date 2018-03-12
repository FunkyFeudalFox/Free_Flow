package freeFlow.model;

public class PipePart extends Space {

    private Orientation orientation;
    private Space connection1;
    private Space connection2;

    public PipePart(int x, int y, Colour colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.isLocked = false;
        //this.orientation = Orientation.VERTICAL;
    }

    public char getConsoleImage() {
        return Character.toLowerCase(colour.getConsoleImage());
    }

    public boolean isCreatePipeValid(Colour colour) {
        return this.colour == colour;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    private void setOrientation() {
        orientation = (x == connection1.getX() ? Orientation.VERTICAL : Orientation.HORIZONTAL);
        if (connection2 == null)
            return;

        switch (orientation) {
            case HORIZONTAL:
                setHorizontalFlow();
                break;
            case VERTICAL:
                setVerticalFlow();
                break;
        }

/*        switch (orientation) {
            case HORIZONTAL:
                if (y == connection2.getY())
                    return;
                if (y < connection2.getY())
                    orientation = Orientation.HORIZONTAL_UP;
                else
                    orientation = Orientation.HORIZONTAL_DOWN;
                break;
            case VERTICAL:
                if (x == connection2.getX())
                    return;
                if (x < connection2.getX())
                    orientation = Orientation.VERTICAL_RIGHT;
                else
                    orientation = Orientation.VERTICAL_LEFT;
                break;
        }*/
    }

    private void setHorizontalFlow() {
        // C1 - this - C2
        if (y == connection2.getY())
            return;

        //      [C2]
        // C1 - this
        //      [C2]
        if (x > connection1.getX()) {
            // C1 - this
            //       C2
            if (y < connection2.getY())
                orientation = Orientation.HORIZONTAL_DOWN;
                //       C2
                // C1 - this
            else
                orientation = Orientation.HORIZONTAL_UP;
            // [C2]
            // this - C1
            // [C2]
        } else {
            // this - C1
            //  C2
            if (y < connection2.getY())
                orientation = Orientation.VERTICAL_RIGHT;
                // C2
                // this - C1
            else
                orientation = Orientation.VERTICAL_LEFT;
        }
    }

    private void setVerticalFlow() {
        //  C1
        // this
        //  C2
        if (x == connection2.getX())
            return;

        //         C1
        // [C2] - this - [C2]
        if (y > connection1.getY()) {
            //       C1
            // C2 - this
            if (x > connection2.getX())
                orientation = Orientation.HORIZONTAL_UP;
                //  C1
                // this - C2
            else
                orientation = Orientation.VERTICAL_LEFT;
            // [C2] - this - [C2]
            //         C1
        } else {
            // this - C2
            //  C1
            if (x < connection2.getX())
                orientation = Orientation.VERTICAL_RIGHT;
                // C2 - this
                //       C1
            else
                orientation = Orientation.HORIZONTAL_DOWN;
        }
    }

    public void setConnection1(Space connector) {
        this.connection1 = connector;
        setOrientation();
    }

    @Override
    public void setLocked(Space connector) {
        this.isLocked = true;
        this.connection2 = connector;
        setOrientation();
    }
}
