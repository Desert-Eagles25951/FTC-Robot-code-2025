package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;

import com.qualcomm.hardware.motors.RevRobotics20HdHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class powertrain extends SubsystemBase {


    private final DifferentialDrive drive;
    private double Wheel_diamenter;

    private final Encoder leftencoder, rightencoder;

    //config
    public powertrain(MotorEx right, MotorEx left, final double diameter) {

       left.setRunMode(Motor.RunMode.VelocityControl);
       right.setRunMode(Motor.RunMode.VelocityControl);

       left.setInverted(true);
       right.setInverted(false);

       left.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
       right.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

       left.resetEncoder();
       right.resetEncoder();

       leftencoder = left.encoder;
       rightencoder = right.encoder;


        drive =  new DifferentialDrive(left,right);
        Wheel_diamenter = diameter;

    }

    //clas for motor name
    public powertrain(HardwareMap hMap, final String leftMotorName, String rightMotorName,
                      final double diameter) {
        this(new MotorEx(hMap, leftMotorName), new MotorEx(hMap, rightMotorName), diameter);
    }

    //arcade drive
    public void arcade(double speed, double turn){

        drive.arcadeDrive(speed,turn);
    }


    public double getLeftEncoderVal() {
        return leftencoder.getPosition();
    }

    public double getLeftEncoderDistance() {
        return leftencoder.getRevolutions() * Wheel_diamenter * Math.PI;
    }

    public double getRightEncoderVal() {
        return rightencoder.getPosition();
    }

    public double getRightEncoderDistance() {
        return rightencoder.getRevolutions() * Wheel_diamenter * Math.PI;
    }

    public void resetEncoders() {
        leftencoder.reset();
        rightencoder.reset();
    }

    public double getAverageEncoderDistance() {
        return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2.0;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}