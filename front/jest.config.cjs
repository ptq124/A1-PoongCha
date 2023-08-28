module.exports = {
  testEnvironment: "jsdom",
  setupFilesAfterEnv: ["<rootDir>/jest.setup.js"],
  testMatch: ["<rootDir>/**/*.test.(js|jsx)"],
  transformIgnorePatterns: ["<rootDir>/node_modules/", "dist", "build"],
};
