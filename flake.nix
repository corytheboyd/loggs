{
  inputs.nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";

  outputs =
    { nixpkgs, ... }:
    {
      devShells.aarch64-darwin.default =
        with nixpkgs.legacyPackages.aarch64-darwin;
        mkShell {
          buildInputs = [
            jdk23
          ];
          shellHook = ''
            ln -sfn ${pkgs.jdk23} ./jdk
          '';
        };
    };
}
