package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    RobotHardware robotHardware = new RobotHardware();

    public void InitHardware(HardwareMap ahw){
        robotHardware.Init(ahw);
    }

    public void LeftDriveMotor(double power){
        robotHardware.leftMotor.setPower(power);
    }

    public void RightDriveMotor(double power){
        robotHardware.rightMotor.setPower(power);
    }

    public void Drive(double lP, double rP){
        robotHardware.leftMotor.setPower(lP);
        robotHardware.rightMotor.setPower(rP);
    }

    public void EleMotor(double power){
        robotHardware.eleMotor.setPower(-power);
    }

    public void RotateMotor(double power){
        robotHardware.rotateMotor.setPower(power);
    }

    public void GrabServoOpen(){
        robotHardware.grabServo.setPosition(1);
    }
    public void GrabServoClose(){
        robotHardware.grabServo.setPosition(0);
    }
}
