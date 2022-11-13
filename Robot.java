package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    int eleHomeTicks = 0;

    int eleAutonHover = -600;

    int eleLowTicks = -1100;
    int eleMidTicks = -1860;
    int eleHighTicks = -2550;

    int rotateLeftTicks = 105;
    int rotateRightTicks = -110;

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

    public void Drive(double p){
        robotHardware.leftMotor.setPower(p);
        robotHardware.rightMotor.setPower(p);
    }

    public void FullDrive(double yStick, double xStick){
        if(xStick > 0){
            robotHardware.leftMotor.setPower(yStick/2-(xStick/2)*.5);
            robotHardware.rightMotor.setPower(yStick/2+(xStick/2)*.5);
        }else if(xStick < 0){
            robotHardware.leftMotor.setPower(yStick/2-(xStick/2)*.5);
            robotHardware.rightMotor.setPower(yStick/2+(xStick/2)*.5);
        }else if(xStick == 0) {
            robotHardware.leftMotor.setPower(yStick * .5);
            robotHardware.rightMotor.setPower(yStick * .5);
        }else if(yStick == 0){
            if (xStick > 0){
                robotHardware.leftMotor.setPower(xStick*.5);
                robotHardware.rightMotor.setPower(-(xStick*.5));
            }else if (xStick < 0){
                robotHardware.leftMotor.setPower(xStick*.5);
                robotHardware.rightMotor.setPower(-(xStick*.5));
            }
        }
    }

    public void Turn(double p){
        robotHardware.leftMotor.setPower(-p);
        robotHardware.rightMotor.setPower(p);
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
        robotHardware.eleMotor.setPower(.5);
    }

    public void EleMotorUp10()
    {
        if(robotHardware.eleMotor.getCurrentPosition()-10 < eleHighTicks)
            robotHardware.eleMotor.setTargetPosition(robotHardware.eleMotor.getCurrentPosition()+10);
    }

    public void EleMotorDown10()
    {
        if (robotHardware.eleMotor.getCurrentPosition()+10 > eleHomeTicks)
            robotHardware.eleMotor.setTargetPosition(robotHardware.eleMotor.getCurrentPosition()-10);
    }

    public void EleMotorStickWithLimits(double pStick){

        int leftLimit = 20;
        int rightLimit = -2550;

        DcMotor eleMotor = robotHardware.eleMotor;

        eleMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        eleMotor.setPower(pStick/2);

        while (eleMotor.getCurrentPosition() <= rightLimit){
            if(pStick > 0){
                eleMotor.setPower(pStick/2);
                break;
            }else{
                eleMotor.setPower(0);
                break;
            }
        }
        while (eleMotor.getCurrentPosition() >= leftLimit){
            if(pStick < 0){
                eleMotor.setPower(pStick/2);
                break;
            }else {
                eleMotor.setPower(0);
                break;
            }
        }
    };

    public void EleMotorTicksAuton(int pos){
        int targetTicks = 0;
        switch (pos){
            case 0:
                robotHardware.eleMotor.setTargetPosition(eleHomeTicks);
                targetTicks = eleHomeTicks;
                break;
            case 1:
                robotHardware.eleMotor.setTargetPosition(eleAutonHover);
                targetTicks = eleAutonHover;
                break;
            case 2:
                robotHardware.eleMotor.setTargetPosition(eleLowTicks);
                targetTicks = eleLowTicks;
                break;
            case 3:
                robotHardware.eleMotor.setTargetPosition(eleMidTicks);
                targetTicks = eleMidTicks;
                break;
            case 4:
                robotHardware.eleMotor.setTargetPosition(eleHighTicks);
                targetTicks = eleHighTicks;
                break;

        }
        robotHardware.eleMotor.setPower(.4);
        if(targetTicks > robotHardware.eleMotor.getCurrentPosition()) {
            while (targetTicks > robotHardware.eleMotor.getCurrentPosition()) {
                if (targetTicks <= robotHardware.eleMotor.getCurrentPosition()) {
                    break;
                }
            }
        }
        if(targetTicks < robotHardware.eleMotor.getCurrentPosition()) {
            while (targetTicks < robotHardware.eleMotor.getCurrentPosition()) {
                if (targetTicks >= robotHardware.eleMotor.getCurrentPosition()) {
                    break;
                }
            }
        }
    }
    public void RotateMotorTicks(int pos) {

        robotHardware.rotateMotor.setTargetPosition(0);
        robotHardware.rotateMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        int targetTicks = 0;
        switch (pos){
            case 0:
                robotHardware.rotateMotor.setTargetPosition(rotateLeftTicks);
                targetTicks = rotateLeftTicks;
                break;
            case 1:
                robotHardware.rotateMotor.setTargetPosition(0);
                targetTicks = 0;
                break;
            case 2:
                robotHardware.rotateMotor.setTargetPosition(rotateRightTicks);
                targetTicks = rotateRightTicks;
                break;

        }
        robotHardware.rotateMotor.setPower(.5);
        if(targetTicks > robotHardware.rotateMotor.getCurrentPosition()) {
            while (targetTicks > robotHardware.rotateMotor.getCurrentPosition()) {
                if (targetTicks <= robotHardware.rotateMotor.getCurrentPosition()) {
                    break;
                }
            }
        }
        if(targetTicks < robotHardware.rotateMotor.getCurrentPosition()) {
            while (targetTicks < robotHardware.rotateMotor.getCurrentPosition()) {
                if (targetTicks >= robotHardware.rotateMotor.getCurrentPosition()) {
                    break;
                }
            }
        }
    }

    public void RotateMotorStickWithLimits(double pStick){

        int leftLimit = 105;
        int rightLimit = -110;

        DcMotor rotateMotor = robotHardware.rotateMotor;

        rotateMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rotateMotor.setPower(pStick/2);

        while (rotateMotor.getCurrentPosition() <= rightLimit){
            if(pStick > 0){
                rotateMotor.setPower(pStick/2);
                break;
            }else{
                rotateMotor.setPower(0);
                break;
            }
        }
        while (rotateMotor.getCurrentPosition() >= leftLimit){
            if(pStick < 0){
                rotateMotor.setPower(pStick/2);
                break;
            }else {
                rotateMotor.setPower(0);
                break;
            }
        }
    };

    public void DriveByInches(double p, double otr){
        DcMotor l = robotHardware.leftMotor;
        DcMotor r = robotHardware.rightMotor;

        final int tpr = 540;
        final double wheelCir = 3.45*Math.PI;

        int ticks = (int) ((otr*tpr)/wheelCir);

        final int lTargetTicks = robotHardware.leftMotor.getCurrentPosition()+ticks;
        final int rTargetTicks = robotHardware.rightMotor.getCurrentPosition()+ticks;

        l.setTargetPosition(0);
        r.setTargetPosition(0);

        l.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        l.setTargetPosition(lTargetTicks);
        r.setTargetPosition(rTargetTicks);

        l.setPower(p);
        r.setPower(p);
        if(lTargetTicks > l.getCurrentPosition() && rTargetTicks > r.getCurrentPosition()) {
            while (lTargetTicks > l.getCurrentPosition() && rTargetTicks > r.getCurrentPosition()) {
                if (lTargetTicks <= l.getCurrentPosition() && rTargetTicks <= r.getCurrentPosition()) {
                    break;
                }
            }
        }
        if(lTargetTicks < l.getCurrentPosition() && rTargetTicks < r.getCurrentPosition()) {
            while (lTargetTicks < l.getCurrentPosition() && rTargetTicks < r.getCurrentPosition()) {
                if (lTargetTicks >= l.getCurrentPosition() && rTargetTicks >= r.getCurrentPosition()) {
                    break;
                }
            }
        }
    }

    public void TurnByInches(double p, int degree, char dir){
        DcMotor l = robotHardware.leftMotor;
        DcMotor r = robotHardware.rightMotor;

        final int tpr = 540;
        final double wheelCir = 3.54331*Math.PI;
        final double rotationalCir = 11.375*Math.PI;
        final double ticksPerInch = tpr/wheelCir;
        final double a135 = 3.75;
        final int a90 = 4;
        final int a45 = 8;

        int ticks = (int) ((tpr/wheelCir)*(rotationalCir/a90));

        switch (degree){
            case 135:
                ticks = (int) (ticksPerInch*(rotationalCir/a135));
                break;
            case 90:
                ticks = (int) (ticksPerInch*(rotationalCir/a90));
                break;
            case 45:
                ticks = (int) (ticksPerInch*(rotationalCir/a45));
                break;
        }

        int lTicks = robotHardware.leftMotor.getCurrentPosition();
        int rTicks = robotHardware.rightMotor.getCurrentPosition();

        if(dir == 'r'){
            lTicks = robotHardware.leftMotor.getCurrentPosition()+ticks;
            rTicks = robotHardware.rightMotor.getCurrentPosition()-ticks;
        }else{
            lTicks = robotHardware.leftMotor.getCurrentPosition()-ticks;
            rTicks = robotHardware.rightMotor.getCurrentPosition()+ticks;
        }

        l.setTargetPosition(0);
        r.setTargetPosition(0);

        l.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        l.setTargetPosition(lTicks);
        r.setTargetPosition(rTicks);

        l.setPower(p);
        r.setPower(p);
        if(lTicks > l.getCurrentPosition() && rTicks < r.getCurrentPosition()) {
            while (lTicks > l.getCurrentPosition() && rTicks < r.getCurrentPosition()) {
                if (lTicks <= l.getCurrentPosition() && rTicks >= r.getCurrentPosition()) {
                    l.setTargetPosition(l.getCurrentPosition());
                    r.setTargetPosition(r.getCurrentPosition());
                    l.setPower(.1);
                    r.setPower(.1);
                    break;
                }
            }
        }
        if(lTicks < l.getCurrentPosition() && rTicks > r.getCurrentPosition()) {
            while (lTicks < l.getCurrentPosition() && rTicks > r.getCurrentPosition()) {
                if (lTicks >= l.getCurrentPosition() && rTicks <= r.getCurrentPosition()) {
                    l.setTargetPosition(l.getCurrentPosition());
                    r.setTargetPosition(r.getCurrentPosition());
                    l.setPower(.1);
                    r.setPower(.1);
                    break;
                }
            }
        }
    };

    public int GetRightMotor(){
        return robotHardware.rightMotor.getCurrentPosition();
    }

    public  int GetLeftMotor(){
        return robotHardware.leftMotor.getCurrentPosition();
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

    public int GetColor(){
        if(robotHardware.colorSensor.red() > robotHardware.colorSensor.blue() && robotHardware.colorSensor.red() > robotHardware.colorSensor.green()){
            return 1;
        }
        if(robotHardware.colorSensor.green() > robotHardware.colorSensor.blue() && robotHardware.colorSensor.green() > robotHardware.colorSensor.red()){
            return 2;
        }
        if(robotHardware.colorSensor.blue() > robotHardware.colorSensor.red() && robotHardware.colorSensor.blue() > robotHardware.colorSensor.green()){
            return 3;
        }
        return 0;
    }
}
