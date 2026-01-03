#!/bin/bash
# Exit immediately if any command fails
set -e
# Check if directory argument is provided
if [ $# -ne 1 ]; then
  echo "Usage: ./file-organizer.sh /path/to/directory"
  exit 1
fi

TARGET_DIR="$1"

# Check if the directory exists

if [ ! -d "$TARGET_DIR" ]; then
  echo "Error: Directory does not exist."
  exit 1
fi

# Move into the target directory
cd "$TARGET_DIR" || exit 1


# Declare an associative array to count files per extension
declare -A file_count

# Loop through files that contain an extension
for file in *.*; do

 # Skip if no matching files
  [ -e "$file" ] || continue

  # Extract file extension
  ext="${file##*.}"


  # Create directory for the extension if it doesn't exist
  mkdir -p "$ext"

  # Move the file into its extension directory
  mv "$file" "$ext/"

  # Increment file count
  ((file_count[$ext]++))
done

# Print summary
for ext in "${!file_count[@]}"; do
  echo "Organized ${file_count[$ext]} .$ext files"
done
