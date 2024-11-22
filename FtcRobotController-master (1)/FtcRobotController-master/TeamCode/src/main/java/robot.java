import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.util.Range;


@TeleOp(name="drive", group="drive.v1")
public class robot extends OpMode
{

    private DcMotor left = null;
    private DcMotor right = null;
<<<<<<< HEAD:FtcRobotController-master (1)/FtcRobotController-master/TeamCode/src/main/java/robot.java

=======
    //arm Motor
    private DcMotor arm1 = null;
    private DcMotor pulley = null;
    private Servo gripper = null;
 
>>>>>>> 47e4bd8cf282c4d8ae5e460ba19444df534d2dbb:TeamCode/src/main/java/robot.java



    @Override
    public void init() {
        left = hardwareMap.get(DcMotor.class,"left");
        right = hardwareMap.get(DcMotor.class,"right");
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        arm1 = hardwareMap.get(DcMotor.class,"arm");
        arm1.setDirection(DcMotorSimple.Direction.REVERSE); // Change for robot

        pulley = hardwareMap.get(DcMotor.class, "poll"); // change name real
        pulley.setDirection(DcMotorSimple.Direction.FORWARD); // Change for robot




    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double X;
        double Z;
        double speed = gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        X = Range.clip(speed + turn, -1, 1);
        Z = Range.clip(speed - turn , -1, 1);
        left.setPower(-X);
        right.setPower(Z);

        //arm subsystem Test
        if (gamepad1.a)
            arm1.setPower(0);
        else if (gamepad1.b)
            arm1.setPower(.5);
        else if(gamepad1.y)
            arm1.setPower(-.5)

        double  y = gamepad1.right.trigger;
        double old = gamepad1.left.trigger;


        pulley.setPower(y -old);










    }

}




