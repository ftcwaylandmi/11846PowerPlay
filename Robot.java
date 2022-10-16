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

    public int ElePos(){
        return robotHardware.eleMotor.getCurrentPosition();
    }

    public void Drive(double lP, double rP){
        robotHardware.leftMotor.setPower(lP);
        robotHardware.rightMotor.setPower(rP);
    }

    public void EleMotorStick(double power){
        robotHardware.eleMotor.setPower(-power/5);
    }

    public void RotateMotorStick(double power){
        robotHardware.rotateMotor.setPower(power/5);
    }

    public void GrabServoOpen(){
        robotHardware.grabServo.setPosition(.5);
    }
    public void GrabServoClose(){
        robotHardware.grabServo.setPosition(.65);
    }
}
