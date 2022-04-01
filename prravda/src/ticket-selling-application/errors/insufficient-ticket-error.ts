export class InsufficientTicketError extends Error {
  constructor(public message: string) {
    super(message);
    Error.captureStackTrace(this);
  }
}
