
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Subsystem;
import edi.wpi.first.wpilibj.smartdashboard.SmartDashboard;

boolean raised;
public class raiseElevator extends Command {
  Subsystem elevator;

  public raiseElevator(Elevator elevator) {
    elevator = elevator;
    requires(elevator);
    addRequirements(elevator);
  }


  @Override
  protected void initialize() {
    raised = SmartDashboard.getBoolean("1");
  }


  @Override
  protected void execute() {
    if (!raised){
        elevator.motor1.set(0.5);
        elevator.motor2.set(0.5);
        SmartDashboard.putBoolean("1", true);
    } else if (raised){
        end();
        SmartDashboard.putBoolean("1", false);
    }
    
  }

  @Override
  protected boolean isFinished() {
    return false;
  }


  @Override
  protected void end() {
    elevator.motor1.set(0);
    elevator.motor2.set(0);
  }


  @Override
  protected void interrupted() {
  }
}
