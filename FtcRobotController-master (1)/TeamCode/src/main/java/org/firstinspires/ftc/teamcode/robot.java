package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;


import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.sql.Time;
import java.util.Collections;
import java.util.Set;
import java.util.Timer;


@TeleOp(name = " Telop")
public class robot extends OpMode
{
  public GamepadEx ps4;
  private powertrain drivetrain;
  private  elevator elevator;
  private  arm_Gripper Arm;


  //rutines


  ElapsedTime timer = new ElapsedTime();



        @Override
        public void init() {
            //subsystem and control
            drivetrain = new powertrain(hardwareMap);
            ps4 = new GamepadEx(gamepad1);
            elevator = new elevator(hardwareMap);
            Arm = new arm_Gripper(hardwareMap);





        }



        @Override
        public void init_loop() {


        }



        @Override
        public void start() {


        }

        @Override
        public void loop() {

           telemetry.addData("angle", "angle (%.2f) ", Arm.getangleArm());
           telemetry.addData("elevator encode", "elevator (%.2f)", elevator.elevatorPos());
            ps4.readButtons();
            drivetrain.inputcontrol(ps4);
            drivetrain.arcade();
            elevator.loop();
            Arm.getangleArm();


            //controls
            // climber boton A, right bumper Take piece,
            if(ps4.wasJustPressed(GamepadKeys.Button.A)){
                elevator.climber();

            }
                else if(ps4.wasJustReleased(GamepadKeys.Button.A)){
                elevator.offsetPOs();
            }
            if(ps4.wasJustPressed(GamepadKeys.Button.RIGHT_BUMPER)){
                Arm.TakePiece();
                Arm.OpenGripper();

            }
            else if (ps4.wasJustReleased(GamepadKeys.Button.RIGHT_BUMPER)) {

                Arm.Gripperoffset();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Arm.armOfseTake();

            }


            if(ps4.wasJustPressed(GamepadKeys.Button.X)){
                Arm.OutPieceBasket();
                elevator.lowBasquet();

            }
            else if( ps4.wasJustReleased(GamepadKeys.Button.X)){
                Arm.OpenGripper();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Arm.ArmOfsetBasket();
                elevator.offsetPOs();
            }
            if (ps4.wasJustPressed(GamepadKeys.Button.LEFT_BUMPER)){
                Arm.OpenGripper();

            }
            else if (ps4.wasJustReleased(GamepadKeys.Button.LEFT_BUMPER)){
                Arm.Gripperoffset();
            }

            if(ps4.wasJustPressed(GamepadKeys.Button.Y)){

                elevator.higChamber();
                Arm.OutPiece();

            }
            else if(ps4.wasJustReleased(GamepadKeys.Button.Y)){

                elevator.Change();




            }
            if(ps4.wasJustPressed(GamepadKeys.Button.B)){

                Arm.OpenGripper();
                Arm.ArmOfsetChamber();
                elevator.offsetPOs();
            }
            if(ps4.wasJustPressed(GamepadKeys.Button.DPAD_RIGHT)){



            }

            }
        }



