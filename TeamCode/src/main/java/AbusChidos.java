import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.util.Range;


    @TeleOp(name="PROTOTIPO", group="pruebas")
    public class AbusChidos extends OpMode
    {

            private DcMotor left = null;
            private DcMotor right = null;





            @Override
            public void init() {
                left = hardwareMap.get(DcMotor.class,"m1");
                right = hardwareMap.get(DcMotor.class,"m2");
                left.setDirection(DcMotorSimple.Direction.REVERSE);
                right.setDirection(DcMotorSimple.Direction.FORWARD);
                left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




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
                double Edy = gamepad1.left_stick_y;
                double Saul = gamepad1.right_stick_x;
                X = Range.clip(Edy + Saul, -1, 1);
                Z = Range.clip(Edy - Saul, -1, 1);
                left.setPower(-X);
                right.setPower(Z);
                // arm




                


        }

    }






