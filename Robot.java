package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    int eleHomeTicks = 0;
    int eleLowTicks = -1100;
    int eleMidTicks = -1860;
    int eleHighTicks = -2550;

    int rotateLeftTicks = 60;
    int rotateRightTicks = -60;

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

    public int GetElePos(){
        return robotHardware.eleMotor.getCurrentPosition();
    }

    public double GetGrabPos(){
        return robotHardware.grabServo.getPosition();
    }

    public int GetRotatePos(){
        return robotHardware.rotateMotor.getCurrentPosition();
    }

    public void Drive(double lP, double rP){
        robotHardware.leftMotor.setPower(lP);
        robotHardware.rightMotor.setPower(rP);
    }

    public void EleMotorStick(double power){
        robotHardware.eleMotor.setPower(-power/5);
    }

    public void RotateArmLeft(){
        robotHardware.rotateMotor.setPower(-.1);
    }
    public void RotateArmRight(){
        robotHardware.rotateMotor.setPower(.1);
    }

    public void EleMotorTicks(int pos){
        switch (pos){
            case 0:
                robotHardware.eleMotor.setTargetPosition(eleHomeTicks);
                break;
            case 1:
                robotHardware.eleMotor.setTargetPosition(eleLowTicks);
                break;
            case 2:
                robotHardware.eleMotor.setTargetPosition(eleMidTicks);
                break;
            case 3:
                robotHardware.eleMotor.setTargetPosition(eleHighTicks);
                break;

        }
        robotHardware.eleMotor.setPower(.2);
    }

    public void RotateMotorTicks(int pos) throws InterruptedException {
        int check = 0;
        switch (pos){
            case -1:
                robotHardware.rotateMotor.setTargetPosition(rotateLeftTicks);
                check = rotateLeftTicks;
                break;
            case 0:
                robotHardware.rotateMotor.setTargetPosition(0);
                check = 0;
                break;
            case 1:
                robotHardware.rotateMotor.setTargetPosition(rotateRightTicks);
                check = rotateRightTicks;
                break;
        }
        robotHardware.rotateMotor.setPower(.2);
    }

    public void RotateMotorStick(double power){
        robotHardware.rotateMotor.setPower(power/5);
    }

    public void GrabServoOpen(){
        robotHardware.grabServo.setPosition(0.40);
    }
    public void GrabServoClose(){
        robotHardware.grabServo.setPosition(.65);
    }
}
