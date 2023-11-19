
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Subsystem;

boolean raised;
public class raiseLower extends Command {
  Subsystem elevator;

  public raiseLower(Elevator elevator) {
    elevator = elevator;
    requires(elevator);
    addRequirements(elevator);
  }


  @Override
  protected void initialize() {
    raised = false;
  }


  @Override
  protected void execute() {
    if (raised) {
        lower();
    } else if (!raised){
        raise();
    }
  }
  private raise(){
      elevator.motor1.set(0.5);
      elevator.motor2.set(0.5);
      rasied = true;
  }
  private lower(){
      elevator.motor1.set(-0.5);
      elevator.motor2.set(-0.5);
      raised = false;

  }

  @Override
  protected boolean isFinished() {
    return false;
  }


  @Override
  protected void end() {
    
  }


  @Override
  protected void interrupted() {
  }
}
